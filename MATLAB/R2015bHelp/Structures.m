clear;clc;
S.name = 'Ed Plum';
S.score = 83;
S.grade = 'B+' ;

S(2).name = 'Toni Miller';
S(2).score = 91;
S(2).grade = 'A-';

S(3)=struct('name','Jerry Garcia',...
    'score',70,'grade','C')

%% Create a nonscalar structure with one field.

field = 'f';
value = {'some text';
         [10, 20, 30];
         magic(5)};
s = struct(field,value)

%% Create a nonscalar structure with several fields.

field1 = 'f1';  value1 = zeros(1,10);
field2 = 'f2';  value2 = {'a', 'b'};
field3 = 'f3';  value3 = {pi, pi.^2};
field4 = 'f4';  value4 = {'fourth'};

s1 = struct(field1,value1,field2,value2,field3,value3,field4,value4)

%% Create a structure with an empty field.Use [] to specify the value of the empty field.

s2 = struct('f1','a','f2',[])

%% Create a structure with a field that contains a cell array.

field = 'mycell';
value = {{'a','b','c'},{2,2}};
s3 = struct(field,value)

%% Create an empty structure with several fields.

s4 = struct('a',{},'b',{},'c',{});

s4(1).a = 'a'

%% Create a nested structure. a is a structure with a field which contains another structure.

a.b = struct('c',{{[2]},{[4]}},'d',{[]})

fieldnames(a.b)