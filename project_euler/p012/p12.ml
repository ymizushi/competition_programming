let count_divisor n = 
  let rec count_divisor base_n div_num count = 
    if div_num = 1 then
      count+1
    else if (base_n mod div_num) = 0 then
      count_divisor base_n (div_num-1) (count+1)
    else count_divisor base_n (div_num-1) count
  in
    count_divisor n n 0;;

let rec triangle_num n = 
  if n = 1 then
    1
  else triangle_num (n-1) + n;;

print_int(count_divisor(triangle_num 7));;
