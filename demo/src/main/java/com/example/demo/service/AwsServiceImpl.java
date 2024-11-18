package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.common.Constants;
import com.example.demo.model.Resource;

import software.amazon.awssdk.services.iam.IamClient;

@Service
@Qualifier("awsServiceImpl")
public class AwsServiceImpl implements CloudService {

	@Autowired
	private IamClient client;

	@Override
	public List<Resource> getResource() throws InterruptedException, ExecutionException {

		CompletableFuture<List<Resource>> futureUser = CompletableFuture.supplyAsync(this::getUser);
		CompletableFuture<List<Resource>> futureRole = CompletableFuture.supplyAsync(this::getRoles);
		CompletableFuture<List<Resource>> futureGroup = CompletableFuture.supplyAsync(this::getGroups);
		CompletableFuture<List<Resource>> futurePolicy = CompletableFuture.supplyAsync(this::getPolicies);

		CompletableFuture<Void> combinedFuture = CompletableFuture.allOf(futureUser, futureRole, futureGroup,
				futurePolicy);
		combinedFuture.join();
		List<Resource> list = new ArrayList<Resource>();
		list.addAll(futureUser.get());
		list.addAll(futureRole.get());
		list.addAll(futureGroup.get());
		list.addAll(futurePolicy.get());

		return list;
	}

	private List<Resource> getUser() {
		List<Resource> users = new ArrayList<Resource>();
		client.listUsers().users().forEach(user -> users.add(new Resource(Constants.ResourceType.IDENTITY.getValue(),
				user.userName(), user.userId(), user.createDate().toString())));
		return users;

	}

	private List<Resource> getRoles() {
		List<Resource> roles = new ArrayList<Resource>();
		client.listRoles().roles().forEach(role -> roles.add(new Resource(Constants.ResourceType.ROLE.getValue(),
				role.roleName(), role.roleId(), role.createDate().toString())));
		return roles;

	}

	private List<Resource> getGroups() {
		List<Resource> groups = new ArrayList<Resource>();
		client.listGroups().groups().forEach(group -> groups.add(new Resource(Constants.ResourceType.GROUP.getValue(),
				group.groupName(), group.groupId(), group.createDate().toString())));

		return groups;

	}

	private List<Resource> getPolicies() {
		List<Resource> policies = new ArrayList<Resource>();
		client.listPolicies().policies()
				.forEach(policy -> policies.add(new Resource(Constants.ResourceType.POLICY.getValue(),
						policy.policyName(), policy.policyId(), policy.createDate().toString())));

		return policies;

	}

}
