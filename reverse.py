def reverse(str):
    stack = []
    for c in str:
        stack += [c]
    reversed_str = ""
    while True:
        if stack:
            reversed_str += stack.pop()
            continue
        return reversed_str

print reverse("foobar")
