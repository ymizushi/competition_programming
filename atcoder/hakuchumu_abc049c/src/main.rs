fn get_line<'a>(mut s: String) -> String {
    std::io::stdin().read_line(&mut s).unwrap();
    s.trim_end().to_owned()
}

fn hakuchumu<'a>(s: &str) -> &'a str {
    if s.len() == 0 {
        return "YES"
    }
    if s.len() >=7 {
        match &s[0..7] {
            "dreamer" => {
                if hakuchumu(&s[7..]) == "YES" {
                    return "YES"
                };
            }
            _ => {}
        }
    }
    if s.len() >=6 {
        match &s[0..6] {
            "eraser" => {
                if hakuchumu(&s[6..]) == "YES" {
                    return "YES"
                }
            }
            _ => {}
        }
    }
    if s.len() >=5 {
        match &s[0..5]{
            "dream" => {
                if hakuchumu(&s[5..]) == "YES" {
                    return "YES"
                }
            }
            "erase" => {
                if hakuchumu(&s[5..]) == "YES" {
                    return "YES"
                }
            }
            _ => {}
        }
    }
    "NO"
}


fn main() {
    let s = get_line(String::new());
    println!("{}", hakuchumu(&s));
}
