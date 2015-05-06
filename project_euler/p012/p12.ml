let count_divisor n = 
  let rec count_divisor base_n div_num count = 
    if div_num = 1 then
      count+1
    else if (base_n mod div_num) = 0 then
      count_divisor base_n (div_num-1) (count+1)
    else count_divisor base_n (div_num-1) count
  in
    count_divisor n n 0;;

let table = Hashtbl.create 2048

let rec triangle_num n = 
  let key = (n) in
  if Hashtbl.mem table key then Hashtbl.find table key
  else
    let value = if n = 1 then 1 else triangle_num (n-1) + n in
    Hashtbl.add table key value;
    value;;

  print_int(count_divisor(100000000));;
(*
  print_int(triangle_num(20010));;
*)
(*
  print_int(count_divisor(triangle_num 40000));;
*)
