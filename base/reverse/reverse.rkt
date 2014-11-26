#!/usr/bin/env racket
#lang racket
(require test-engine/racket-tests)

(define (rev-str lst stack)
  (if (eq? lst null)
    (list->string  stack)
    (rev-str (rest lst) (cons (first lst) stack))))

(define (reverse str)
  (rev-str (string->list str) null))

(check-expect (reverse  "abcdefghijklmnopqrstu") "utsrqponmlkjihgfedcba")
(test)
