.class public Lnumeric;
.super Ljava/lang/Object;

.method public static simple1()I
    .locals 1

    const/4 v0, 0x1

    const/4 v0, 0x5

    const/4 v0, 0x7

    return v0
.end method

.method public static simple2()I
    .locals 1

    const/4 v0, 0x2

    const/4 v0, 0x5

    const/16 v0, 0x42

    return v0
.end method

.method public static trim_unused1()V
    .locals 2

    const/4 v0, 0x2

    const/4 v1, 0x7

    return-void
.end method

.method public static simple_ops1()I
    .locals 3

    const/4 v2, 0x7

    return v2
.end method

.method public static intra_method1()I
    .locals 2

    const/4 v0, 0x2

    const/4 v1, 0x2

    goto :someLabel

    :otherLabel
    add-int v2, v2, v2

    goto :end

    :someLabel
    add-int v2, v0, v1

    goto :otherLabel

    :end
    return v2
.end method