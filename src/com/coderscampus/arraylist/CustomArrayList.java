package com.coderscampus.arraylist;


public class CustomArrayList<T> implements CustomList<T> {
	Object[] items = new Object[10];
	int size = 0;
	
	
	
	@Override
	public boolean add(T item) {
		if (items.length == size) {
			expendBackingObjectArray();
		}
		items[size++] = item;
		return true;
	}

	
	
	@Override
	public boolean add(int index, T item) throws IndexOutOfBoundsException {
		
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException ("Index Out Of Bounds: " + index);
		} if (size + 1 > items.length) {
			expendBackingObjectArray();
		}
		for (int i = size ; i > index; i--) {
			items[i] = items[i - 1];
		}
		
		items[index] = item;
		size++;
		return true;
	}

	

	@Override
	public int getSize() {
		return size;
	}

	
	
	@SuppressWarnings("unchecked")
	@Override
	public T get(int index) throws IndexOutOfBoundsException{
		return (T) items[index];
	}

	

	@Override
	public T remove(int index) throws IndexOutOfBoundsException {
	    if (index < 0 || index >= size) {
	        throw new IndexOutOfBoundsException("Index Out Of Bounds: " + index);
	    }
	    T removedItem = get(index);
	    for (int i = index; i < size - 1; i++) {
	        items[i] = items[i + 1];
	    }
	    items[size - 1] = null;
	    size--;
	    if (items.length == size * 2) {
	        trimBackingObjectArray();
	    }
	    return removedItem;
	}
	
	
	
	private void expendBackingObjectArray() {
		Object[] oldArray = items;
		items = new Object[size * 2];
		for (int i=0; i<oldArray.length; i++) {
			items[i] = oldArray[i];
		}
	}
	
	
	
	private void trimBackingObjectArray() {
	    Object[] oldArray = items;
	    items = new Object[size];
	    int copyLength = Math.min(oldArray.length, size);
	    for (int i = 0; i < copyLength; i++) {
	        items[i] = oldArray[i];
	    }
	}
}
