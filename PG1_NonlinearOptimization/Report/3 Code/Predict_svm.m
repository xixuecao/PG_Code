function result = Predict_svm(svm, Xt, Yt)
% 计算末尾的b值
temp = (svm.a.*svm.Ysv)'*(svm.Xsv*svm.Xsv');
total_b = svm.Ysv'-temp;
b = mean(total_b);
% 计算w*x
w_x = (svm.a.*svm.Ysv)'*(svm.Xsv*Xt');

% result.score = w_x + b; % 最后得到的值
Y = sign(w_x+b); % 分类
result.Y = Y;
result.accuracy = size(find(Y==Yt'))/size(Yt'); % 准确率

