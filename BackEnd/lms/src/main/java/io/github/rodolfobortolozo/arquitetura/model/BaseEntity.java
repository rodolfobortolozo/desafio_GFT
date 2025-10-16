package io.github.rodolfobortolozo.arquitetura.model;

import java.io.Serializable;


public abstract class BaseEntity<T extends Serializable> {

    T getId;
}
