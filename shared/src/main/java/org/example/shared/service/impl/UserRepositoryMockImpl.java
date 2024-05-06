package org.example.shared.service.impl;

import org.example.shared.domain.User;
import org.example.shared.exception.DbException;
import org.example.shared.service.UserRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class UserRepositoryMockImpl implements UserRepository {
    private final Map<String, User> users = new HashMap<>();
    private final ReadWriteLock lock = new ReentrantReadWriteLock();

    @Override
    public void addUser(User user) {
        lock.writeLock().lock();
        try {
            if (users.containsKey(user.getBirthNumber())) {
                throw new DbException("User already exists");
            }
            users.put(user.getBirthNumber(), user);
        } finally {
            lock.writeLock().unlock();
        }
    }

    @Override
    public void deleteUser(String birthNumber) {
        lock.writeLock().lock();
        try {
            if (!users.containsKey(birthNumber)) {
                throw new DbException("User doesn't exist");
            }
            users.remove(birthNumber);
        } finally {
            lock.writeLock().unlock();
        }
    }

    @Override
    public User getUser(String birthNumber) {
        lock.readLock().lock();
        try {
            if (!users.containsKey(birthNumber)) {
                throw new DbException("User doesn't exist");
            }
            return users.get(birthNumber);
        } finally {
            lock.readLock().unlock();
        }
    }

}
