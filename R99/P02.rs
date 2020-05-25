fn main() {
    let l = vec![1,1,2,3,5,8];
    assert_eq!(5, penumerate(l));
}

fn penumerate<E>(e: Vec<E>)  -> E where E: Copy {
    let len = e.len();
    e[len-2]
}
