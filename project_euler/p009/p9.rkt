#!/usr/bin/env racket
#lang racket
(require test-engine/racket-tests)

(define (calc-triplet lim)
  (let loop-a ([a 1])
    (let loop-b ([b (add1 a)])
      (let ([c (- lim a b)])
        (if (and (< a b c) (= (+ (* a a) (* b b)) (* c c)))
          (* a b c)
          (cond
            [(<= b (- 1000 a)) (loop-b (add1 b))]
            [(<= a (round (/ lim 3))) (loop-a (add1 a))]
            [else (displayln (list a b c))]))))))

(check-expect (calc-triplet 1000) 31875000)
(test)
