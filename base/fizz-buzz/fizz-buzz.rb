def fizz_buzz(num)
    if num % 15 == 0
        p num.to_s + ": Fizz Buzz"
    elsif num % 3 == 0
        p num.to_s +  ": Fizz"
    elsif num % 5 == 0
        p num.to_s + ": Buzz" 
    end
end


(1..100).map {|num| fizz_buzz(num) }
