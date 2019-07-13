[dayNum, dayString] = weekday(date, 'long', 'en_US');

switch dayString
case 'Monday'
disp('Start of the work week')
case 'Tuesday'
disp('Day 2')
case 'Wednesday'
disp('Day 3')
case 'Thursday'
disp('Day 4')
case 'Friday'
disp('Last day of the work week')
otherwise
disp('Weekend!')
end

%% both if and switch
yourNumber = input('Enter a number: ');
if yourNumber < 0
disp('Negative')
elseif yourNumber > 0
disp('Positive')
else
disp('Zero')
end