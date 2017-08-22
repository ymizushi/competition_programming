def mod(a, b)
    if a - b < 0
        a
    else
        mod(a-b, b)
    end
end

p mod(100, 3)
