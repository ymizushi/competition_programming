def reverse(input)
    head = input[0]
    rest = input[1, input.length]
    if rest.length == 1
        return rest[0] + head
    else
        return reverse(rest) + head
    end
end

p reverse("watashinonamaehamizushima")


# time : 30s
