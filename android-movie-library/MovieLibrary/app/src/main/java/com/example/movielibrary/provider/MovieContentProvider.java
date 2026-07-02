package com.example.movielibrary.provider;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;

public class MovieContentProvider extends ContentProvider {

    MovieDatabase md;
    private final String TABLE_NAME = "movieTable";
    public static final String CONTENT_AUTHORITY="fit2081.app.HANS";
    public static final Uri CONTENT_URI= Uri.parse("content://"+CONTENT_AUTHORITY);

    public MovieContentProvider() {
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        int deletionCount;

        deletionCount = md
                .getOpenHelper()
                .getWritableDatabase()
                .delete(TABLE_NAME, selection, selectionArgs);

        return deletionCount;
    }

    @Override
    public String getType(Uri uri) {
        // TODO: Implement this to handle requests for the MIME type of the data
        // at the given URI.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        long rowId = md
                .getOpenHelper()
                .getWritableDatabase()
                .insert(TABLE_NAME, 0, values);

        return ContentUris.withAppendedId(CONTENT_URI, rowId);
    }

    @Override
    public boolean onCreate() {
        md = MovieDatabase.getDatabase(getContext());
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        // TODO: Implement this to handle query requests from clients.
        SQLiteQueryBuilder builder = new SQLiteQueryBuilder();
        builder.setTables(TABLE_NAME);
        String query = builder.buildQuery(projection, selection, null, null, sortOrder, null);

        final Cursor cursor = md
                .getOpenHelper()
                .getReadableDatabase()
                .query(query, selectionArgs);

        return cursor;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        int updateCount;
        updateCount = md
                .getOpenHelper()
                .getWritableDatabase()
                .update(TABLE_NAME, 0, values, selection, selectionArgs);

        return updateCount;
    }
}