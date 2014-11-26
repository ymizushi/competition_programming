#!/usr/bin/env racket
#lang racket
(require test-engine/racket-tests)

(define (merge a b)
  (define (merge a b l)
    (cond 
      [(and (null? a) (null? b)) l]
      [(and (null? a) (not (null? b)))
         (merge a (rest b) (append l (list (first b))))]
      [(and (not (null? a)) (null? b))
         (merge (rest a) b (append l (list (first a))))]
      [(>=  (first a) (first b))
         (merge a (rest b) (append l (list (first b))))]
      [(< (first a) (first b))
         (merge (rest a) b (append l (list (first a))))]))
    (merge a b null))

(define (split l)
  (let ([m (/ (length l) 2)])
    (cons (take l m) (drop l m))))

(define (sort a)
  (if (< 2 (length a))
    (let ([splitted (split a)])
      (merge
        (sort (first splitted))
        (sort (rest splitted))))
    (if (= 1 (length a))
      a
      (if (< (first a) (last a))
        a
        (list (last a) (first a)))))) 

(check-expect (merge  '(4 9 10 11) '(2 8 12 13)) '(2 4 8 9 10 11 12 13))
(check-expect (split  '(4 9 10 11)) (cons (list 4 9) (list 10 11)))
(check-expect (sort  '(11 50 43 2 50 1 2 5)) '(1 2 2 5 11 43 50 50))
(test)
