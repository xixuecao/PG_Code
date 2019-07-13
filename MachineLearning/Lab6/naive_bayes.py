import numpy as np
import os
from collections import Counter
from sklearn.metrics import confusion_matrix

def make_Dictionary(train_dir):
    emails = [os.path.join(train_dir,f) for f in os.listdir(train_dir)]    
    all_words = []       
    for mail in emails:    
        with open(mail) as m:
            for i,line in enumerate(m):
                if i == 2:  #Body of email is only 3rd line of text file
                    words = line.split()
                    all_words += words
    
    dictionary = Counter(all_words)
    # Paste code for non-word removal here(code snippet is given below) 
    list_to_remove = dictionary.keys()
    for item in list(list_to_remove):
        if item.isalpha() == False: 
            del dictionary[item]
        elif len(item) == 1:
            del dictionary[item]
    dictionary = dictionary.most_common(3000)
    return dictionary

def extract_features(mail_dir): 
    files = [os.path.join(mail_dir,fi) for fi in os.listdir(mail_dir)]
    features_matrix = np.zeros((len(files),3000))
    docID = 0
    for fil in files:
      with open(fil) as fi:
        for i,line in enumerate(fi):
          if i == 2:
            words = line.split()
            for word in words:
              wordID = 0
              for i,d in enumerate(dictionary):
                if d[0] == word:
                  wordID = i
                  features_matrix[docID,wordID] = words.count(word)
        docID = docID + 1     
    return features_matrix

def trainNB0(trainMatrix, trainCategory):
    # 总email数
    numTrainDocs = len(trainMatrix)
    # 总变量数
    numWords = len(trainMatrix[0])
    # 侮辱性文件的出现概率
    pAbusive = sum(trainCategory) / float(numTrainDocs)
    # 构造单词出现次数列表
    # p0Num 正常的统计
    # p1Num 侮辱的统计
    p0Num = np.ones(numWords)
    p1Num = np.ones(numWords)

    # 整个数据集单词出现总数，2.0根据样本/实际调查结果调整分母的值（2主要是避免分母为0，当然值可以调整）
    # p0Denom 正常的统计
    # p1Denom 侮辱的统计
    p0Denom = 2.0
    p1Denom = 2.0
    for i in range(numTrainDocs):
        if trainCategory[i] == 1:
            # 累加辱骂词的频次
            p1Num += trainMatrix[i]
            # 对每篇文章的辱骂的频次 进行统计汇总
            p1Denom += sum(trainMatrix[i])
        else:
            p0Num += trainMatrix[i]
            p0Denom += sum(trainMatrix[i])
    # 类别1，即spam的[log(P(F1|C1)),log(P(F2|C1)),log(P(F3|C1)),log(P(F4|C1)),log(P(F5|C1))....]列表
    p1Vect = np.log(p1Num / p1Denom)
    # 类别0，即ham的[log(P(F1|C0)),log(P(F2|C0)),log(P(F3|C0)),log(P(F4|C0)),log(P(F5|C0))....]列表
    p0Vect = np.log(p0Num / p0Denom)
    return p0Vect, p1Vect, pAbusive

def classifyNB(testk, p0Vec, p1Vec, pClass1):
    # 计算公式  log(P(F1|C))+log(P(F2|C))+....+log(P(Fn|C))+log(P(C))
    # 上面的计算公式，没有除以贝叶斯准则的公式的分母，也就是 P(w) （P(w) 指的是此文档在所有的文档中出现的概率）就进行概率大小的比较了，
    # 因为 P(w) 针对的是包含侮辱和非侮辱的全部文档，所以 P(w) 是相同的。
    # 使用 NumPy 数组来计算两个向量相乘的结果，这里的相乘是指对应元素相乘，即先将两个向量中的第一个元素相乘，然后将第2个元素相乘，以此类推。
    # 我的理解是：这里的 testk * p1Vec 的意思就是将每个词与其对应的概率相关联起来
    p1 = sum(testk * p1Vec) + np.log(pClass1) # P(w|c1) * P(c1)
    p0 = sum(testk * p0Vec) + np.log(1.0 - pClass1) # P(w|c0) * P(c0)
    if p1 > p0:
        return 1
    else:
        return 0

# Create a dictionary of words with its frequency

train_dir = 'D:/PG_SUSTech1/Fall_Semester/Machine_learning/Python/Lab6/ling-spam/train-mails'
dictionary = make_Dictionary(train_dir)
train_labels = np.zeros(702)
train_labels[351:701] = 1
train_matrix = extract_features(train_dir)

# Test the unseen mails for Spam
test_dir = 'D:/PG_SUSTech1/Fall_Semester/Machine_learning/Python/Lab6/ling-spam/test-mails'
test_matrix = extract_features(test_dir)
test_labels = np.zeros(260)
test_labels[130:260] = 1

# 训练数据
p0V, p1V, pAb = trainNB0(train_matrix, train_labels)
# 测试数据
result = []
for testk in test_matrix:
#    num_1 += classifyNB(testk, p0V, p1V, pAb)
    result = np.append(result,classifyNB(testk, p0V, p1V, pAb))

#print(result)
final_matrix = confusion_matrix(test_labels,result)
TP = final_matrix[0][0]
FP = final_matrix[0][1]
FN = final_matrix[1][0]
TN = final_matrix[1][1]
p = TP / (TP + FP)
r = TP / (TP + FN)
F1 = 2 * r * p / (r + p)
acc = (TP + TN) / (TP + TN + FP + FN)
print(final_matrix)
print("precision: ", "%.4f" % p, " accuracy: ", "%.4f" % acc, " recall: ", "%.4f" % r, " F1-scroe: ", "%.4f" % F1)


