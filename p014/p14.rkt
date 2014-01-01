#!/usr/bin/env racket
#lang racket
(require test-engine/racket-tests)

(define (next-collatz n)
  (if (even? n)
    (quotient n 2)
    (+ (* 3 n) 1)))

(define (collatz-list n [lst (list)])
  (if (= n 1)
    lst
    (collatz-list (next-collatz n) (cons n lst))))

(define (collatz-list-max-num n [max-len 0] [max-num 0])
  (if (> n 0)
    (let ([now-len (length (collatz-list n))])
      (if (> now-len max-len)
        (collatz-list-max-num (- n 1) now-len n)
        (collatz-list-max-num (- n 1) max-len max-num)))
    max-num))

(check-expect (collatz-list 13) `(2 4 8 16 5 10 20 40 13))
(check-expect (collatz-list-max-num 1000000) 837799)
(test)

;(time (collatz-list-max-len 1000000))
