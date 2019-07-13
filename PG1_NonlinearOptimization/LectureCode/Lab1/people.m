
function people(file,varargin)
people = [];
switch varargin{1}
    case 'reset'
        people = [];
        save(file,'people');
    case 'list'
        load(file);
        for i = 1:length(people)
            disp([people(i).name, ' ', num2str(people(i).age)])
        end
    case 'insert'
        for i = 1:(length(varargin) - 1)/2
            temp.name = varargin{2*i};
            temp.age = varargin{2*i + 1};
            people = [people, temp];
            save(file,'people');
        end
    case 'remove'
        load(file);
        index = [];
        for i = 1:length(people)
            for j = 1:(length(varargin) - 1)/2
            if strcmpi(people(i).name,varargin{2*j}) & people(i).age == varargin{2*j + 1}
                index = [index, i];
            end
            end
        end
        people(index) = [];
        save(file,'people');
    otherwise
        fprintf('error');
end
end