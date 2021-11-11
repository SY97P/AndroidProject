package com.example.roomexample.dataBase;

import java.lang.System;

/**
 * 3. RoomDatabase 상속
 *
 * 데이터베이스를 생성하고 관리하는 데이터베이스 객체
 * RoomDatabase 객체를 상속받아야 하므로 abstract class로 선언.
 *
 * @Database annotation에 데이터베이스에 들어갈 entities를 선언.
 * 들어갈 객체가 많다면 ','를 통해 열거해주면 된다.
 * version은 처음 데이터베이스를 생성한다면 1로 설정하면 된다.
 */
@androidx.room.Database(entities = {com.example.roomexample.entity.User.class}, version = 1)
@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&\u00a8\u0006\u0006"}, d2 = {"Lcom/example/roomexample/dataBase/UserDatabase;", "Landroidx/room/RoomDatabase;", "()V", "userDao", "Lcom/example/roomexample/dataBase/UserDao;", "Companion", "app_debug"})
public abstract class UserDatabase extends androidx.room.RoomDatabase {
    @org.jetbrains.annotations.NotNull()
    public static final com.example.roomexample.dataBase.UserDatabase.Companion Companion = null;
    private static com.example.roomexample.dataBase.UserDatabase instance;
    
    public UserDatabase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.roomexample.dataBase.UserDao userDao();
    
    /**
     * 4. 데이터베이스 사용 (singleton)
     *
     * 안드로이드 스튜디오는 공식적으로 데이터베이스 객체 인스턴스를 싱글톤으로 하도록 권장.
     *
     * companion object{} : 싱글톤 선언
     * databaseBuilder()  : 데이터베이스 객체 선언 (인스턴스)
     *
     * databaseBuilder(Context, DataBase 클래스, database 이름)
     */
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/example/roomexample/dataBase/UserDatabase$Companion;", "", "()V", "instance", "Lcom/example/roomexample/dataBase/UserDatabase;", "getInstance", "context", "Landroid/content/Context;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.Nullable()
        public final synchronized com.example.roomexample.dataBase.UserDatabase getInstance(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
            return null;
        }
    }
}