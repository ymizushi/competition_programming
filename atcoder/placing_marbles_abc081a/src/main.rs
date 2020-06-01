fn get_line<'a>(mut s: String) -> String {
    std::io::stdin().read_line(&mut s).unwrap();
    s.trim_end().to_owned()
}

fn main() {
    let input = {
        let s = get_line(String::new());
        s
    };
    let mut result = 0;
    for c in input.chars() {
        result += c.to_string().parse::<i32>().unwrap();
    }

    println!("{}", result);
}
