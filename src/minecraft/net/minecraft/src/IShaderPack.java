package net.minecraft.src;

import java.io.InputStream;

public interface IShaderPack
{
    void close();

    InputStream getResourceAsStream(String var1);
}
