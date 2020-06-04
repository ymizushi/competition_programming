fn get_line<'a>(mut s: String) -> String {
    std::io::stdin().read_line(&mut s).unwrap();
    s.trim_end().to_owned()
}

fn hakuchumu<'a>(s: &str) -> &'a str {
    if s.len() == 0 {
        return "YES"
    }
    if s.len() >= 11 {
        match &s[0..11] {
            "dreameraser" => {
                return hakuchumu(&s[11..]);
            }
            _ => {}
        }
    }
    if s.len() >= 10 {
        match &s[0..10] {
            "dreamerase" => {
                return hakuchumu(&s[10..]);
            }
            _ => {}
        }
    }
    if s.len() >=7 {
        match &s[0..7] {
            "dreamer" => {
                return hakuchumu(&s[7..]);
            }
            _ => {}
        }
    }
    if s.len() >=6 {
        match &s[0..6] {
            "eraser" => {
                return hakuchumu(&s[7..]);
            }
            _ => {}
        }
    }
    if s.len() >=5 {
        match &s[0..5]{
            "dream" => {
                return hakuchumu(&s[5..]);
            }
            "erase" => {
                return hakuchumu(&s[5..]);
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
