package com.example.tarek.news.views.articles;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.tarek.news.R;
import com.example.tarek.news.models.search.Article;
import com.example.tarek.news.views.bases.ArticleArrayAdapter;
import com.example.tarek.news.views.bases.BaseFragment;

import java.util.List;

import butterknife.BindView;

import static com.example.tarek.news.utils.ViewsUtils.commitFragment;


public class ArticlesFragment extends BaseFragment {

    @BindView(R.id.list_view)
    ListView listView;

    private ArticleArrayAdapter adapter  ;
    private List<Article> articles ;

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_articles;
    }

    @Override
    protected void initiateValues() {
        adapter = new ArticleArrayAdapter(activity);
        setListView();
    }

    @Override
    protected void setUI() {
        adapter.clear();
        adapter.addAll(articles);
    }

    private void setListView() {
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Article article = adapter.getItem(position);
                try {
                    Intent openWebPage;
                    if (article != null) {
                        openWebPage = new Intent(Intent.ACTION_VIEW, Uri.parse(article.getWebUrl()));
                        startActivity(openWebPage);
                    }
                } catch (ActivityNotFoundException e) {
                    showToastMsg(getString(R.string.no_browser_msg));
                }
            }
        });
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public static void setArticlesFragmentToCommit (FragmentManager fm, int containerId,  List<Article> articleList){
        ArticlesFragment fragment = ArticlesFragment.getInstance(articleList);
        commitFragment(fm, containerId, fragment);
    }

    public static ArticlesFragment getInstance(List<Article> articles) {
        ArticlesFragment articlesFragment = new ArticlesFragment();
        articlesFragment.setArticles(articles);
        return articlesFragment;
    }
}
