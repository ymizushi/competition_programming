#!/usr/bin/env racket
#lang racket
(require test-engine/racket-tests)

(define (prime? n)
  (cond 
    [(not (integer? n)) (begin (print "n must be integer!") false)]
    [(< n 2) false]
    [else 
      (let loop ([cnt 2])
        (if (= (remainder n cnt) 0)
          (if (= n cnt) true false)
          (loop (+ 1 cnt))))]))
(check-expect (prime? 1) false)
(check-expect (prime? 2) true)
(check-expect (prime? 3) true)
(check-expect (prime? 19) true)

(define (list-prime n)
  (let loop ([i 0] [prime-list null])
    (if (= n i)
      prime-list
      (if (prime? i)
        (loop (+ 1 i) (cons i prime-list))
        (loop (+ 1 i) prime-list)))))

(define (max-prime n)
  )

(max-prime 10)

(test)
