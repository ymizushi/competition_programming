def rev(str)
    stack = []
    output = ""
    str.each_char do |c|
        stack.unshift(c)
    end
    for c in stack do 
        output << c
    end
    output
end

def revrec(str)
    def rev_l(head, rest) 
        if rest == ""
            head
        else
            rev_l(rest[0]+head, rest[1..-1])
        end
    end
    if str.length <= 1
        str
    else
        rev_l(str[0], str[1..-1])
    end
end

p revrec("piyopiyo")
p rev("piyopiyo")
