package ru.stqa.pft.github;

import com.google.common.collect.ImmutableMap;
import com.jcabi.github.*;
import org.testng.annotations.Test;

import java.io.IOException;

public class GitHubTest {

    @Test
    public void testCommits() throws IOException {
        Github github = new RtGithub("4206d754d482bdcfbd462354e06fa85e6c4b6a7f ");
        RepoCommits commits = github.repos().get(new Coordinates.Simple("K0tani", "devel_java")).commits();
        for (RepoCommit commit : commits.iterate(new ImmutableMap.Builder<String, String>().build())) {
            System.out.println(new RepoCommit.Smart(commit).message());
        }
    }
}