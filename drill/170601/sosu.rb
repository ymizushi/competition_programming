def get_sosu n
    counter = 0
    (1..n).each {|i|
        if n % i == 0
            counter += 1
        end
    }
    if counter == 2
        true
    else
        false
    end
end


p get_sosu(101)
# time 30s
