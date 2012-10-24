package com.example.document;

import net.csdn.mongo.Document;
import net.csdn.mongo.association.Options;
import net.csdn.mongo.embedded.AssociationEmbedded;

import static net.csdn.common.collections.WowCollections.map;

/**
 * User: WilliamZhu
 * Date: 12-10-24
 * Time: 上午11:35
 */
public class Blog extends Document {
    static {
        storeIn("blogs");

        hasManyEmbedded("articles", new Options(map(
                Options.n_kclass, Article.class
        )));

    }

    public AssociationEmbedded articles() {
        return associationsEmbeddedMetaData().get("articles").doNotUseMePlease_newMe(this);
    }

    //properties and their access methods
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getBlogTitle() {
        return blogTitle;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
    }

    private String userName;
    private String blogTitle;

}