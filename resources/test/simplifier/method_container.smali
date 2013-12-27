.class public LMethodContainer;
.super Ljava/lang/Object;

.method public static method1()V
    .locals 0

    return-void
.end method

.method public static method2()I
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    const/4 v0, 0x2

    return v0
.end method

.method public static intra_class()I
    .locals 1

    invoke-static {}, LMethodContainer;->method2()I

    move-result v0

    return v0
.end method

.method public static intra_method()I
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

.method public static inter_class()V
    .locals 0

    invoke-static {}, Lsome/unknown/class;->someMethod()V
.end method