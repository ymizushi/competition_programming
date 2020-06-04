fn get_line<'a>(mut s: String) -> String {
    std::io::stdin().read_line(&mut s).unwrap();
    s.trim_end().to_owned()
}

fn traveling<'a>(v: Vec<(i32, i32, i32)>) -> &'a str {
    let mut current_position = (0, 0, 0);
    for item in v.into_iter() {
        if traveling_line(current_position, item) == "No" {
            return "No"
        }
        current_position = item;
    }
    "Yes"
}

fn traveling_line<'a>(current_position:(i32, i32, i32), t: (i32, i32, i32)) -> &'a str {
    let relative_position = ( t.0 - current_position.0, t.1 - current_position.1, t.2 - current_position.2);
    if relative_position.1.abs() + relative_position.2.abs() <= relative_position.0 {
        if relative_position.0 % 2 == 0 && (relative_position.1 + relative_position.2) % 2 == 0    
            || (relative_position.0 % 2 != 0 && (relative_position.1 + relative_position.2) % 2 != 0) {
                return "Yes"
        }
    }         
    "No"
}

fn main() {
    let n = {
        let s = get_line(String::new());
        s.parse().unwrap()
    };
    let mut lines = vec![];
    {
        for _ in 0..n {
            let s = get_line(String::new());
            let mut ws = s.split_whitespace(); 
            let t: i32 = ws.next().unwrap().parse().unwrap();
            let x: i32 = ws.next().unwrap().parse().unwrap();
            let y: i32 = ws.next().unwrap().parse().unwrap();
            lines.push((t, x, y))
        }
    };

    println!("{}", traveling(lines));
}
