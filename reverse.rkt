#!/usr/bin/env racket
#lang racket
(define (rev-str lst stack)
  (if (eq? lst null)
    (list->string  stack)
    (rev-str (rest lst) (cons (first lst) stack))))
(rev-str (string->list "abcdefghijklmnopqrstu") null)
