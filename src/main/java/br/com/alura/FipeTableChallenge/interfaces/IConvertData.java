package br.com.alura.FipeTableChallenge.interfaces;

public interface IConvertData {
    <T> T getData(String json, Class<T> clazz);
}
