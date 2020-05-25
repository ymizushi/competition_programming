fn main() {
    let hoge = vec![1,1,2,3,6,5];
    println!("{}", last(&hoge));
}

fn last<E>(e: &Vec<E>) -> &E {
    e.last().unwrap()
}
