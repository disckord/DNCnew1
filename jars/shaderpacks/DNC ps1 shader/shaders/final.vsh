#version 120

varying vec4 texcoord;

void main()
{
gl_Position =  gl_ModelViewProjectionMatrix * gl_Vertex;
gl_Position /= gl_Position.w;
texcoord = gl_MultiTexCoord0;
}