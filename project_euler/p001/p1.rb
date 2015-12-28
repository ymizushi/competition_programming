def is_3_or_5_times_num(num)
    if num % 5 == 0 || num % 3 == 0
        true
    else
        false
    end
end

p (1..999).select {|num| is_3_or_5_times_num(num) }.inject (:+)
