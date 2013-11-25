#!/usr/bin/env racket
#lang racket
(require test-engine/racket-tests)

(define (prime? n)
  (cond 
    [(not (integer? n)) (begin (print "n must be integer!") false)]
    [(= n 1) false]
    [(= n 2) true]
    [else 
      (let loop ([cnt 2])
        (if (<= cnt (round (sqrt n)))
          (if (= (remainder n cnt) 0)
            false
            (loop (add1 cnt)))
          true))]))
(check-expect (prime? 1) false)
(check-expect (prime? 2) true)
(check-expect (prime? 3) true)
(check-expect (prime? 19) true)

(define (prime-lst n)
  (let loop ([i 2] [n n] [l (list)])
    (if (i . <= . n)
      (if (and (= 0 (remainder n i)) (prime? i))
        (let ([max (/ n i)])
          (loop 2 max (append l (list i))))
        (loop (add1 i) n l))
      (apply max l))))
;
(check-expect (prime-lst 600851475143) 6857)
(test)
