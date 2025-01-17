clc;
clear;
%% Problem Definition
CostFunction=@ ft;  % Cost Function
nVar=3;             % Number of Decision Variables
VarSize=[nVar 1];   % Decision Variables Matrix Size
VarMin = [0.5 -2 -2]';         % Decision Variables Lower Bound
VarMax = [1 2 2]';         % Decision Variables Upper Bound
nObj=numel(CostFunction(unifrnd(VarMin,VarMax,VarSize)));
%% MOEA Settings
MaxIt=50;  % Maximum Number of Iterations
nPop=100;    % Population Size (Number of Sub-Problems)
nArchive=50;
T=max(ceil(0.15*nPop),2);    % Number of Neighbors
T=min(max(T,2),15);
crossover_params.gamma=0.7;
crossover_params.VarMin=VarMin;
crossover_params.VarMax=VarMax;
%% Initialization
% Create Sub-problems
sp=CreateSubProblems(nObj,nPop,T);
% Empty Individual
empty_individual.Position=[];
empty_individual.Cost=[];
empty_individual.g=[];
empty_individual.IsDominated=[];
% Initialize Goal Point
z=zeros(nObj,1);
% Create Initial Population
pop=repmat(empty_individual,nPop,1);
for i=1:nPop
    pop(i).Position=unifrnd(VarMin,VarMax,VarSize);
    pop(i).Cost=CostFunction(pop(i).Position);
    z=min(z,pop(i).Cost);
end
for i=1:nPop
    pop(i).g=DecomposedCost(pop(i),z,sp(i).lambda);
end

% Determine Population Domination Status
pop=DetermineDomination(pop);

% Initialize Estimated Pareto Front
EP=pop(~[pop.IsDominated]);

%% Main Loop

for it=1:MaxIt
    for i=1:nPop
        
        % Reproduction (Crossover)
        K=randsample(T,2);
        
        j1=sp(i).Neighbors(K(1));
        p1=pop(j1);
        
        j2=sp(i).Neighbors(K(2));
        p2=pop(j2);
        
        y=empty_individual;
        y.Position=Crossover(p1.Position,p2.Position,crossover_params);
        
        y.Cost=CostFunction(y.Position);
        
        z=min(z,y.Cost);
        
        for j=sp(i).Neighbors
            y.g=DecomposedCost(y,z,sp(j).lambda);
            if y.g<=pop(j).g
                pop(j)=y;
            end
        end
        
    end
    
    % Determine Population Domination Status
	pop=DetermineDomination(pop);
    
    ndpop=pop(~[pop.IsDominated]);
    
    EP=[EP
        ndpop];
    
    EP=DetermineDomination(EP);
    EP=EP(~[EP.IsDominated]);
    
    if numel(EP)>nArchive
        Extra=numel(EP)-nArchive;
        ToBeDeleted=randsample(numel(EP),Extra);
        EP(ToBeDeleted)=[];
    end
    

end
PlotCosts(EP);
%% Reults
EPC=[EP.Cost];
for j=1:nObj
    
    disp(['f #' num2str(j) ':']);
    disp(['      Min = ' num2str(min(EPC(j,:)))]);
    disp(['      Max = ' num2str(max(EPC(j,:)))]);
    disp(['    Range = ' num2str(max(EPC(j,:))-min(EPC(j,:)))]);
    disp(' ');
    
end


