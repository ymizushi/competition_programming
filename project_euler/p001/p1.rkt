#!/usr/bin/env racket
#lang racket
(require test-engine/racket-tests)

(define (sum-multi n [sum 0])
  (if (= n 0)
    sum
    (if (or
          (= 0 (remainder n 3))
          (= 0 (remainder n 5)))
      (sum-multi (- n 1) (+ sum n))
      (sum-multi (- n 1) sum))))

;dot表記を試してみた
(define (sum-multi-dot n [sum 0])
  (if (n . = . 0)
    sum
    (if ((0 . = . (n . remainder . 3))
          . or .
          (0 . = . (n . remainder . 5)))
      (sum-multi-dot ( n . - . 1) (sum . + . n))
      (sum-multi-dot ( n . - . 1) sum))))

(sum-multi 999)

(check-expect (sum-multi 9) 23)
(check-expect (sum-multi 999) 233168)
(test)
