#!/usr/bin/env racket
#lang racket
(require test-engine/racket-tests)

(define (power-digit-sum base n)
  (foldl
    +
    0
    (map
      (lambda (x) (char->integer x))
      (string->list (number->string (expt base n))))))
(test)
