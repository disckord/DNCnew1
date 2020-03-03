package net.minecraft.src;

import java.io.InputStream;

public class ShaderPackDefault implements IShaderPack
{
    public void close() {}

    public InputStream getResourceAsStream(String var1)
    {
        return ShaderPackDefault.class.getResourceAsStream(var1);
    }
}
