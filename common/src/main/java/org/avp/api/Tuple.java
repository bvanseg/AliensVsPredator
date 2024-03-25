package org.avp.api;

public record Tuple<A, B>(
    A first,
    B second
) {}
