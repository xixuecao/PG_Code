function result = Predict_svm(svm, Xt, Yt)
% ����ĩβ��bֵ
temp = (svm.a.*svm.Ysv)'*(svm.Xsv*svm.Xsv');
total_b = svm.Ysv'-temp;
b = mean(total_b);
% ����w*x
w_x = (svm.a.*svm.Ysv)'*(svm.Xsv*Xt');

% result.score = w_x + b; % ���õ���ֵ
Y = sign(w_x+b); % ����
result.Y = Y;
result.accuracy = size(find(Y==Yt'))/size(Yt'); % ׼ȷ��

