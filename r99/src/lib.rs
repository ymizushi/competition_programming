pub fn last<E>(e: &Vec<E>) -> E where E: Copy {
    e.last().unwrap().clone()
}

pub fn penumerate<E>(v: &Vec<E>)  -> E where E: Copy {
    let len = v.len();
    v[len-2]
}

pub fn nth<T>(v: &Vec<T>, i: usize) -> T where T: Copy {
    v[i]
}

pub fn length<T>(v: &Vec<T>) -> usize where T: Copy {
    v.len()
}

pub fn reverse<T>(v: &mut Vec<T>) -> &Vec<T> {
    v.reverse();
    v
}

pub fn pallndrome<T>(v: Vec<T>) -> bool where T: PartialEq {
    let len = v.len();
    let end_index = len-1;
    for i in 0..end_index {
        if v[i] != v[end_index-i] {
            return false
        }
    }
    true
}

pub fn flatten<T>(a: Node<T>) -> Vec<T> {
    use Node::*;
    match a {
        One(x) => vec![x],
        Many(xs) => xs.into_iter().flat_map(|x: Node<T>| flatten(x).into_iter()).collect(),
    }
}

pub fn compress<T>(v: Vec<T>) -> Vec<T> where T: PartialEq {
    v.into_iter().fold(Vec::new(), |mut acc, x| {
        match acc.last() {
            Some(a) if *a == x => {
                acc
            },
            _ => {
                acc.push(x);
                acc
            }
        }
    })
}

pub fn pack<T>(v: Vec<T>) -> Vec<Vec<T>> where T: PartialEq  {
    v.into_iter().fold(vec![], |mut acc, x| {
        match acc.last_mut() {
            Some(a) => {
                match a.last() {
                    Some(b) if *b == x => {
                        a.push(x);
                        acc
                    }
                    _ => {
                        acc.push(vec![x]);
                        acc
                    }
                }
            },
            None => {
                acc.push(vec![x]);
                acc
            }
        }
    })
}

pub fn encode<T>(v: Vec<T>) -> Vec<(u32, T)> where T: PartialEq {
    v.into_iter().fold(vec![], |mut acc, x| {
        match acc.last_mut() {
            Some(a) if a.1 == x => {
                a.0 += 1;
                acc
            },
            _ => {
                acc.push((1, x));
                acc
            }
        }
    })
}

#[derive(Debug, PartialEq)]
pub enum Any<T> {
    Many(u32, T),
    One(T),
}

pub fn encode_modified<T>(v: Vec<T>) -> Vec<Any<T>> where T: PartialEq + Copy {
    use Any::*;
    v.into_iter().fold(vec![], |mut acc, x| {
        match acc.last_mut() {
            Some(a) => {
                match a {
                    Many(n, c) => {
                        if *c == x {
                            *a = Many(*n + 1, *c);
                            acc
                        } else {
                            acc.push(One(x));
                            acc
                        }
                    }
                    One(c) => {
                        if *c == x {
                            *a = Many(2, *c);
                            acc
                        } else {
                            acc.push(One(x));
                            acc
                        }
                    }
                }
            },
            None => {
                acc.push(One(x));
                acc
            }
        }
    })
}

pub fn decode<T: Copy>(v: Vec<(u32, T)>) -> Vec<T> {
    v.into_iter().fold(Vec::new(), |mut acc, x| {
        let index = &x.0;
        for _ in 0..*index {
            acc.push(x.1);
        }
        acc
    })
}

pub enum Node<T> {
    One(T),
    Many(Vec<Node<T>>),
}

pub fn encode_direct<T>(v: Vec<T>) -> Vec<(u32, T)> where T: PartialEq {
    v.into_iter().fold(vec![], |mut acc, x| {
        match acc.last_mut() {
            Some(a) if a.1 == x => {
                a.0 += 1;
                acc
            },
            _ => {
                acc.push((1, x));
                acc
            }
        }
    })
}

pub fn duplicate<T>(v: Vec<T>) -> Vec<T>  where T: Copy {
    v.into_iter().fold(Vec::new(), |mut acc, x| {
        acc.push(x);
        acc.push(x);
        acc
    })
}

pub fn duplicate_n<T>(n: i32, v: Vec<T>) -> Vec<T>  where T: Copy {
    v.into_iter().fold(Vec::new(), |mut acc, x| {
        for _ in 0..n {
            acc.push(x)
        }
        acc
    })
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn p01_last() {
        let v = vec![1,1,2,3,6,5];
        assert_eq!(5, last(&v));
    }

    #[test]
    fn p02_penumerate() {
        let v = vec![1,1,2,3,6,5];
        assert_eq!(6, penumerate(&v));
    }

    #[test]
    fn p03_nth() {
        let v = vec![1,1,2,3,6,5];
        assert_eq!(1, nth(&v, 0));
        assert_eq!(1, nth(&v, 1));
        assert_eq!(5, nth(&v, 5));
    }

    #[test]
    #[should_panic]
    fn p03_nth_failed() {
        let v = vec![1,1,2,3,6,5];
        assert_eq!(1, nth(&v, 6));
    }

    #[test]
    fn p04_length() {
        let v = vec![1,1,2,3,6,5];
        assert_eq!(6, length(&v));
    }

    #[test]
    fn p05_reverse() {
        let mut v = vec![1,1,2,3,6,5];
        assert_eq!(&vec![5, 6, 3, 2, 1, 1], reverse(&mut v));
    }

    #[test]
    fn p06_pallndrome() {
        assert!(pallndrome(vec![1,2,3,2,1]));
        assert!(!pallndrome(vec![1,3,3,2,1]));
    }

    #[test]
    fn p07_flatten() {
        use super::Node::*;
        let xs = Many(
            vec![
                Many(vec![One(1), One(1)]),
                One(1),
                Many(vec![
                     One(3),
                     Many(vec![One(5), One(8)])]
                ),
            ]
        );
        assert_eq!(vec![1, 1, 1, 3 ,5 ,8], flatten(xs));
    }

    #[test]
    fn p08_compress() {
        assert_eq!(vec!['a', 'b', 'c', 'a' ,'d' ,'e'], compress(vec!['a', 'a', 'a', 'a', 'b', 'c', 'c', 'a', 'a', 'd', 'e', 'e', 'e', 'e']));
    }

    #[test]
    fn p09_pack() {
        assert_eq!(vec![vec!['a', 'a', 'a', 'a'], vec!['b'], vec!['c', 'c'], vec!['a', 'a'] ,vec!['d'] ,vec!['e', 'e', 'e', 'e']], pack(vec!['a', 'a', 'a', 'a', 'b', 'c', 'c', 'a', 'a', 'd', 'e', 'e', 'e', 'e']));
    }

    #[test]
    fn p10_encode() {
        assert_eq!(vec![(4, 'a'), (1, 'b'), (2, 'c'), (2, 'a') ,(1, 'd') ,(4, 'e')], encode(vec!['a', 'a', 'a', 'a', 'b', 'c', 'c', 'a', 'a', 'd', 'e', 'e', 'e', 'e']));
    }

    #[test]
    fn p11_encode_modified() {
        use super::Any::*;
        assert_eq!(vec![Many(4, 'a'), One('b'), Many(2, 'c'), Many(2, 'a') , One('d') , Many(4, 'e')], encode_modified(vec!['a', 'a', 'a', 'a', 'b', 'c', 'c', 'a', 'a', 'd', 'e', 'e', 'e', 'e']));
    }

    #[test]
    fn p12_decode() {
        assert_eq!(vec!['a', 'a', 'a', 'a', 'b', 'c', 'c', 'a', 'a', 'd', 'e', 'e', 'e', 'e'], decode(vec![(4, 'a'), (1, 'b'), (2, 'c'), (2, 'a') ,(1, 'd') ,(4, 'e')]));
    }

    #[test]
    fn p13_encode_direct() {
        assert_eq!(vec![(4, 'a'), (1, 'b'), (2, 'c'), (2, 'a') ,(1, 'd') ,(4, 'e')], encode_direct(vec!['a', 'a', 'a', 'a', 'b', 'c', 'c', 'a', 'a', 'd', 'e', 'e', 'e', 'e']));
    }

    #[test]
    fn p14_duplicate() {
        assert_eq!(vec!['a', 'a', 'b', 'b', 'c', 'c', 'c', 'c', 'd', 'd'], duplicate(vec!['a', 'b', 'c', 'c', 'd']));
    }

    #[test]
    fn p15_duplicate_n() {
        assert_eq!(vec!['a', 'a', 'a', 'b', 'b', 'b', 'c', 'c', 'c', 'c', 'c', 'c', 'd', 'd', 'd'], duplicate_n(3, vec!['a', 'b', 'c', 'c', 'd']));
    }
}
