function [dot, h] = findpath_go(dots)
dot.x = round(rand(1, 1)*20);
dot.y = 0;
h = plot(dot.x, dot.y, 'bo','MarkerFaceColor','b');

while dot.y ~= 20
    index = find(dots.x == dot.x);
    if ismember(dot.y + 1, dots.y(index)) == 1
        indexl = find(dots.y == dot.y);
        if ismember(dot.x - 1, dots.x(indexl)) == 1 & ismember(dot.x + 1, dots.x(indexl)) == 1
            return
        elseif ismember(dot.x - 1, dots.x(indexl)) == 0 & dot.x - 1 >= 0
            dots.x = [dots.x, dot.x];
            dots.y = [dots.y, dot.y];
            dot.x = dot.x - 1;
        elseif ismember(dot.x + 1, dots.x(indexl)) == 0 & dot.x + 1 <= 20
            dots.x = [dots.x, dot.x];
            dots.y = [dots.y, dot.y];
            dot.x = dot.x + 1;
        else
            break;
        end
    else
    dots.x = [dots.x, dot.x];
    dots.y = [dots.y, dot.y];
    dot.y = dot.y + 1;
    end
    h = [h, plot(dot.x, dot.y, 'bo','MarkerFaceColor','b')];
end
end

