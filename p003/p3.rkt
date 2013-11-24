#!/usr/bin/env racket
#lang racket
(require test-engine/racket-tests)

(define (prime? n)
  (cond 
    [(not (integer? n)) (begin (print "n must be integer!") false)]
    [(< n 2) false]
    [(= n 2) true]
    [else 
      (let loop ([cnt 3])
        (if (= cnt (round (sqrt n)))
          true
          (if (= (remainder n cnt) 0)
            false
            (loop (add1 cnt)))))]))
(check-expect (prime? 1) false)
(check-expect (prime? 2) true)
(check-expect (prime? 3) true)
(check-expect (prime? 19) true)

;(define (last-prime n)
;  (let loop ([i (round (/ n 2))])
;    (if (= n i)
;      prime-list
;      (if (prime? i)
;        i
;        (loop (add1 i))))))
;
;(check-expect (apply max (last-prime 600851475143)) 17)
(test)
