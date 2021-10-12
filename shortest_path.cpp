#include <bits/stdc++.h>

std::vector<std::vector<int>> adj;
std::set<int> vis;

int
main()
{
	int lines;
	std::cin >> lines;
	adj = std::vector<std::vector<int>>(lines);

	for (int i = 0; i < lines; i++)
	{
		int edges;
		std::cin >> edges;

		for (int j = 0; j < edges; j++)
		{
			int edge;
			std::cin >> edge;

			adj[i].push_back(edge);
		}
	}

	std::list<int> queue;
	std::vector<int> dep(lines);
	std::vector<int> pred(lines);
	int front;

	queue.push_back(0);
	vis.insert(0);
	dep[0] = 1;

	while (!queue.empty())
	{
		front = queue.front();
		queue.pop_front();

		for (int next : adj[front])
		{
			if (next == 59 || next == 61 || next == 68 || next == 71)
			{
				std::cout << "dep[front] = " << dep[front] << std::endl;
				std::cout << "shortest path = " << next << " " << front << " ";
				goto end;
			}

			if (!vis.count(next))
			{
				vis.insert(next);
				dep[next] = dep[front] + 1;
				pred[next] = front;
				queue.push_back(next);
			}
		}
	}

	end:

	while (pred[front] != 0)
	{
		front = pred[front];
		std::cout << front << " ";
	}

	std::cout << "0" << std::endl;
}

