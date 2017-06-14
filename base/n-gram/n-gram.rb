#!/usr/bin/env ruby

def n_gram n, stats, base_str
    for i in (0..base_str.length-n)
        partilal_str = base_str.slice(i, n)
        if stats[partilal_str] 
            stats[partilal_str].push(i)
        else
            stats[partilal_str] = []
            stats[partilal_str].push(i)
        end
    end
    stats
end

p n_gram(2, {}, "watashi no namae ha mizushima yuta desu")
