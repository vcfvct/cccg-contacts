package org.cccgermantown.web.model;

import javax.persistence.*;

/**
 * Created by LeOn on 5/2/15.
 */
@Entity
@Table(name = "HYMNS", schema = "", catalog = "cccg")
public class HymnsEntity
{
    private int id;
    private String lyric;
    private String name;
    private String musicBook;

    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    @Basic
    @Column(name = "lyric", nullable = true, insertable = true, updatable = true, length = 2048)
    public String getLyric()
    {
        return lyric;
    }

    public void setLyric(String lyric)
    {
        this.lyric = lyric;
    }

    @Basic
    @Column(name = "name", nullable = true, insertable = true, updatable = true, length = 64)
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    @Basic
    @Column(name = "music_book", nullable = true, insertable = true, updatable = true, length = 256)
    public String getMusicBook()
    {
        return musicBook;
    }

    public void setMusicBook(String musicBook)
    {
        this.musicBook = musicBook;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HymnsEntity that = (HymnsEntity) o;

        if (id != that.id) return false;
        if (lyric != null ? !lyric.equals(that.lyric) : that.lyric != null) return false;
        if (musicBook != null ? !musicBook.equals(that.musicBook) : that.musicBook != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = id;
        result = 31 * result + (lyric != null ? lyric.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (musicBook != null ? musicBook.hashCode() : 0);
        return result;
    }
}
