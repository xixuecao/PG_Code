function varargout = orthonormal(varargin)
% ��Ҫ�ж�һ�������������������չ�ʽ���뷽�̼���
varargout{1} = varargin{1}/norm(varargin{1});
for j = 2:nargout
    temp = 0;
    for i = 1:j - 1
        temp = temp + varargin{j}'*varargout{1}*varargout{1};
    end
    t = varargin{j} - temp;
    varargout{j} = t/norm(t);
end
end

