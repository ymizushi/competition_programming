def sm(n):
    sm_list =[]
    sm_number = 1
    for i in n:
        sm_number *= n
        for n in sm_number:
            
        if sm_number % not n in sm_list:
            sm_list += [n]
